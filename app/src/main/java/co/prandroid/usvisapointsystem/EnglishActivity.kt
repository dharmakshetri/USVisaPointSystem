package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_education.*

import kotlinx.android.synthetic.main.activity_english.*

class EnglishActivity : AppCompatActivity() {

    var englishPoint:Int=0

    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    val INDEX:String = "englishindex"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)

        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val englishIndex= sharedPref!!.getInt(INDEX, 110)
        englishPoint=sharedPref!!.getInt(Common.ENGLISH,0)

        editor = sharedPref!!.edit()
        radioGroupEngslish.check(englishIndex)
        tvEnglishPoint.text=" $englishPoint point"
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.sixty -> {
                if (checked){
                    englishPoint=0
                    tvEnglishPoint.text=" $englishPoint point"
                }
            }
            R.id.sixtyToEighty -> {
                if (checked){
                    englishPoint=6
                    tvEnglishPoint.text=" $englishPoint point"
                }
            }
            R.id.eightyToNinty -> {
                if (checked){
                    englishPoint=10
                    tvEnglishPoint.text=" $englishPoint point"
                }
            }
            R.id.nightyToNintyNine -> {
                if (checked){
                    englishPoint=11
                    tvEnglishPoint.text=" $englishPoint point"
                }
            }
            R.id.hundred -> {
                if (checked){
                    englishPoint=12
                    tvEnglishPoint.text=" $englishPoint point"
                }
            }

        }

        editor!!.putInt(INDEX, radioGroupEngslish.getCheckedRadioButtonId())
        editor!!.putInt(Common.ENGLISH,englishPoint);
        editor!!.apply()
    }

    fun englishPreviousClick(view: View){
        val iEnglish= Intent(applicationContext, EducationActivity::class.java)
        startActivity(iEnglish)
    }

    fun englishNextClick(view: View){
        val iEnglish= Intent(applicationContext, JobActivity::class.java)
        startActivity(iEnglish)
    }
}
