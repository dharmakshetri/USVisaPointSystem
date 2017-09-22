package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_age.*
import kotlinx.android.synthetic.main.activity_final_result.*
import android.view.animation.Animation
import android.view.animation.AlphaAnimation




class FinalResultActivity : AppCompatActivity() {

    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    var agePoint:Int=0
    var educationPoint:Int=0
    var englishPoint:Int=0
    var jobPoint:Int=0
    var investorPoint:Int=0
    var olympicPoint:Int=0
    var nobelPoint:Int=0
    var spousesPoint:Int=0
    var totalpoint:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        editor = sharedPref!!.edit()

        agePoint=sharedPref!!.getInt(Common.AGE,0)
        educationPoint=sharedPref!!.getInt(Common.EDUCATION,0)
        englishPoint=sharedPref!!.getInt(Common.ENGLISH,0)
        investorPoint=sharedPref!!.getInt(Common.INVESTOR,0)
        olympicPoint=sharedPref!!.getInt(Common.OLYMPIC,0)
        jobPoint=sharedPref!!.getInt(Common.JOB,0)
        nobelPoint=sharedPref!!.getInt(Common.NOBEL,0)

        setValuesToView()

        displayTotalPoint()



    }

    //calculate total point
    private fun displayTotalPoint() {

        totalpoint=agePoint+educationPoint+englishPoint+jobPoint+investorPoint+olympicPoint+nobelPoint+spousesPoint
        tvTotalPoint.text=" Your total Point is $totalpoint"

        if(totalpoint>=30){
            tvTotalPointMessage.text=resources.getString(R.string.result_yes_message)
            tvTotalPoint.setTextColor(resources.getColor(R.color.pointColor))
        }else{
            tvTotalPointMessage.text=resources.getString(R.string.result_no_message)
            tvTotalPoint.setTextColor(resources.getColor(R.color.redAlert))
        }
        editor!!.putInt(Common.TOTAL_POINT,totalpoint);
        editor!!.apply()
    }


    private fun setValuesToView() {
        textViewAgePoint.text=agePoint.toString()
        textViewEducationPoint.text=educationPoint.toString()
        textViewEnglishPoint.text=englishPoint.toString()
        textViewJobPoint.text=jobPoint.toString()
        textViewInestorPoint.text=investorPoint.toString()
        textViewNobelPoint.text=nobelPoint.toString()
        textViewOlympicsPoint.text=olympicPoint.toString()
        textViewSpousesPoint.text=spousesPoint.toString()
    }

    fun reportPreviousClick(view: View){
        val iJob= Intent(applicationContext, AgeActivity::class.java)
        startActivity(iJob)
    }
    fun refrenceClick(view: View){
        val iJob= Intent(applicationContext, RefrenceActivity::class.java)
        startActivity(iJob)
    }

    fun ageClick(view: View){
        val iJob= Intent(applicationContext, AgeActivity::class.java)
        startActivity(iJob)
    }

    fun englishClick(view: View){
        val iJob= Intent(applicationContext, EnglishActivity::class.java)
        startActivity(iJob)
    }

    fun educationClick(view: View){
        val iJob= Intent(applicationContext, EducationActivity::class.java)
        startActivity(iJob)
    }
    fun jobClick(view: View){
        val iJob= Intent(applicationContext, JobActivity::class.java)
        startActivity(iJob)
    }
    fun investorClick(view: View){
        val iJob= Intent(applicationContext, InvesterActivity::class.java)
        startActivity(iJob)
    }

    fun olympicsClick(view: View){
        val iJob= Intent(applicationContext, OlympicsActivity::class.java)
        startActivity(iJob)
    }

    fun nobelClick(view: View){
        val iJob= Intent(applicationContext, NobelActivity::class.java)
        startActivity(iJob)
    }

    fun spousesClick(view: View){
        val iJob= Intent(applicationContext, SpousesActivity::class.java)
        startActivity(iJob)
    }
}
