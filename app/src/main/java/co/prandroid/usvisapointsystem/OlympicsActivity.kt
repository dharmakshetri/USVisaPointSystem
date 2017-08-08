package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import com.google.android.gms.ads.AdRequest

import kotlinx.android.synthetic.main.activity_olympics.*

class OlympicsActivity : AppCompatActivity() {

    var olympicsPoint:Int=0
    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    val INDEX:String = "olympicindex"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olympics)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val nobelValue= sharedPref!!.getBoolean(INDEX, false)
        olympicsPoint=sharedPref!!.getInt(Common.OLYMPIC,0)

        editor = sharedPref!!.edit()
        isOlympicWinner.setChecked(nobelValue)
        tvOlympicsPoint.text=" $olympicsPoint point"
    }
    fun onCheckBoxClicked(view: View) {
        // Is the button now checked?
        val checked = (view as CheckBox).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.isOlympicWinner -> {
                if (checked){
                    olympicsPoint=15
                    tvOlympicsPoint.text=" $olympicsPoint point"
                    editor!!.putBoolean(INDEX, true)
                }else{
                    olympicsPoint=0
                    tvOlympicsPoint.text="$olympicsPoint point"
                    editor!!.putBoolean(INDEX,false)
                }
            }

        }
        editor!!.putInt(Common.OLYMPIC,olympicsPoint);
        editor!!.apply()
    }

    fun olympicsPreviousClick(view: View){
        //TODO: go to next page with subtract for this value
        val iJob= Intent(applicationContext, NobelActivity::class.java)
        startActivity(iJob)
    }

    fun olympicsSkipClick(view: View){
        //TODO: DO not include the value for this view
        val iJob= Intent(applicationContext, InvesterActivity::class.java)
        startActivity(iJob)
    }

    fun olympicsNextClick(view: View){
        //TODO: add the value for this view
        val iJob= Intent(applicationContext, InvesterActivity::class.java)
        startActivity(iJob)
    }
}