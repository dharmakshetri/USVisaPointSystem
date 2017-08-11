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

import kotlinx.android.synthetic.main.activity_nobel.*

class NobelActivity : AppCompatActivity() {

    var nobelPoint:Int=0
    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    val INDEX:String = "nobelindex"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nobel)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val nobelValue= sharedPref!!.getBoolean(INDEX, false)
        nobelPoint=sharedPref!!.getInt(Common.NOBEL,0)

        editor = sharedPref!!.edit()
        isNobelWinner.setChecked(nobelValue)
        tvNobelPoint.text=" $nobelPoint point"
    }

    fun onCheckBoxClicked(view: View) {
        // Is the button now checked?
        val checked = (view as CheckBox).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.isNobelWinner -> {
                if (checked){
                    nobelPoint=25
                    tvNobelPoint.text="$nobelPoint point"
                    editor!!.putBoolean(INDEX, true)
                }else{
                    nobelPoint=0
                    tvNobelPoint.text=" $nobelPoint point"
                    editor!!.putBoolean(INDEX, false)
                }
            }

        }


        editor!!.putInt(Common.NOBEL,nobelPoint);
        editor!!.apply()
    }

    fun nobelPreviousClick(view: View){
        val iJob= Intent(applicationContext, JobActivity::class.java)
        startActivity(iJob)
    }

    fun nobelSkipClick(view: View){
        val iJob= Intent(applicationContext, OlympicsActivity::class.java)
        startActivity(iJob)
    }

    fun nobelNextClick(view: View){
        val iJob= Intent(applicationContext, OlympicsActivity::class.java)
        startActivity(iJob)
    }
}