package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.*


import kotlinx.android.synthetic.main.activity_job.*
import java.util.stream.Collectors
import com.google.android.gms.ads.AdView



import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize

class JobActivity : AppCompatActivity() {

    var jobPoint:Int=0
    private val TAG = "JobActivity"

    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    val INDEX:String = "jobindex"

     var  annualHouseholdIncom: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        etMonthly.setHint(resources.getString(R.string.monthly))
        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val jobIndex= sharedPref!!.getInt(INDEX, 110)
        jobPoint=sharedPref!!.getInt(Common.JOB,0)


        editor = sharedPref!!.edit()
        radioGroupJob.check(jobIndex)
        tvJobPoint.text=" $jobPoint point"
        val statesList = ArrayList<String>(Common.statesIncome.keys)

        val arrayAdapter=ArrayAdapter(applicationContext,android.R.layout.simple_expandable_list_item_1,statesList)
        spinStates.adapter=arrayAdapter

        spinStates.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {

                val item = parent.getItemAtPosition(pos)

                (view as TextView).setTextColor(resources.getColor(R.color.textColor))
                annualHouseholdIncom=Common.statesIncome[item]!!.toDouble()
                tvStatesAnnual.text="Annual Household Income: "+annualHouseholdIncom.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        })


    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.onepointfivetimes -> {
                if (checked){
                    jobPoint=5
                    tvJobPoint.text=" $jobPoint point"
                }
            }
            R.id.doubletimes -> {
                if (checked){
                    jobPoint=8
                    tvJobPoint.text=" $jobPoint point"
                }
            }
            R.id.tripletimes -> {
                if (checked){
                    jobPoint=13
                    tvJobPoint.text=" $jobPoint point"
                }
            }

        }

        editor!!.putInt(INDEX, radioGroupJob.getCheckedRadioButtonId())
        editor!!.putInt(Common.JOB,jobPoint);
        editor!!.apply()
    }

    fun checkClick(view: View){
        if(etMonthly.text.toString().length==0|| etMonthly.text.toString().toDouble()< 1000.0)
            return
        var monthlySalary:Double=etMonthly.text.toString().toDouble()
        var annunalYourIncome:Double=monthlySalary*12

        var yourPercentile:Double
        yourPercentile=annunalYourIncome / annualHouseholdIncom!!.toDouble()
        println("yourPercentile:"+yourPercentile)
        if(yourPercentile<1.5){
            //TODO: selected respective spinner
            jobPoint=0
            radioGroupJob.check(0)
            Toast.makeText(applicationContext,"You don't get any point", Toast.LENGTH_SHORT).show()
        }
        else if(yourPercentile>=1.5 && yourPercentile<=2.0){
            //TODO: selected respective spinner
                jobPoint=5
                radioGroupJob.check(radioGroupJob.getChildAt(0).id)

        }
        else if(yourPercentile>2.0 && yourPercentile<=3.0){
                //TODO: selected respective spinner
                jobPoint=8
                radioGroupJob.check(radioGroupJob.getChildAt(1).id)
        }
        else if(yourPercentile>3.0){
                //TODO: selected respective spinner
                jobPoint=13
                radioGroupJob.check(radioGroupJob.getChildAt(2).id)
        }


        tvJobPoint.text=" $jobPoint point"
        editor!!.putInt(INDEX, radioGroupJob.getCheckedRadioButtonId())
        editor!!.putInt(Common.JOB,jobPoint);
        editor!!.apply()
    }

    fun jobPreviousClick(view: View){
        val iJob= Intent(applicationContext, EnglishActivity::class.java)
        startActivity(iJob)
    }

    fun jobNextClick(view: View){
        val iJob= Intent(applicationContext, NobelActivity::class.java)
        startActivity(iJob)
    }
}


