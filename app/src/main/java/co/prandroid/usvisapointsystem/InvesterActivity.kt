package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import com.google.android.gms.ads.AdRequest


import com.google.android.gms.ads.AdView



import com.google.android.gms.ads.AdSize
import kotlinx.android.synthetic.main.activity_invester.*


class InvesterActivity : AppCompatActivity() {

    var investerPoint:Int=0
    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    val INDEX:String = "investorindex"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invester)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val investorIndex= sharedPref!!.getInt(INDEX, 110)
        investerPoint=sharedPref!!.getInt(Common.INVESTOR,0)

        println("INvestor Index: $investorIndex")
        editor = sharedPref!!.edit()
        radioGroupInvestor.check(investorIndex)
        tvInvestorPoint.text=" $investerPoint point"
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.onepoint3million -> {
                if (checked){
                    investerPoint=5
                    tvInvestorPoint.text=" $investerPoint point"
                }
            }
            R.id.onepinteight -> {
                if (checked){
                    investerPoint=8
                    tvInvestorPoint.text=" $investerPoint point"
                }
            }

            R.id.notInterested -> {
                if (checked){
                    investerPoint=0
                    tvInvestorPoint.text=" $investerPoint point"
                }
            }

        }
        editor!!.putInt(INDEX, radioGroupInvestor.getCheckedRadioButtonId())
        editor!!.putInt(Common.INVESTOR,investerPoint);
        editor!!.apply()
    }

    fun investorPreviousClick(view: View){
        //TODO: go to next page with subtract for this value
        val iJob= Intent(applicationContext, OlympicsActivity::class.java)
        startActivity(iJob)
    }

    fun investorSkipClick(view: View){
        //TODO: DO not include the value for this view
        val iJob= Intent(applicationContext, SpousesActivity::class.java)
        startActivity(iJob)
    }

    fun investorNextClick(view: View){
        //TODO: add the value for this view
        val iJob= Intent(applicationContext, SpousesActivity::class.java)
        startActivity(iJob)
    }
}
