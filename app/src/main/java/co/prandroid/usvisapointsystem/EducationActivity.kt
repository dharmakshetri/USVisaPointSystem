package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_age.*

import kotlinx.android.synthetic.main.activity_education.*

class EducationActivity : AppCompatActivity() {

    var  educationPoint:Int=0
    var sharedPref: SharedPreferences? = null
    var  editor: SharedPreferences.Editor? = null
    val INDEX:String = "educationindex"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)
        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val educationIndex= sharedPref!!.getInt(INDEX, 110)
        educationPoint=sharedPref!!.getInt(Common.EDUCATION,0)

        editor = sharedPref!!.edit()
        radioGroupEducation.check(educationIndex)
        tvEducationPoint.text=" $educationPoint point"
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.highschool -> {
                if (checked){
                    educationPoint=1
                    tvEducationPoint.text=" $educationPoint point"
                }
            }
            R.id.bdforeign -> {
                if (checked){
                    educationPoint=5
                    tvEducationPoint.text=" $educationPoint point"
                }
            }
            R.id.bdus -> {
                if (checked){
                    educationPoint=6
                    tvEducationPoint.text=" $educationPoint point"
                }
            }
            R.id.mdfoerign -> {
                if (checked){
                    educationPoint=7
                    tvEducationPoint.text=" $educationPoint point"
                }
            }
            R.id.mdus -> {
                if (checked){
                    educationPoint=8
                    tvEducationPoint.text=" $educationPoint point"
                }
            }
            R.id.pdforeign -> {
                if (checked){
                    educationPoint=10
                    tvEducationPoint.text=" $educationPoint point"
                }
            }
            R.id.pdus -> {
                if (checked){
                    educationPoint=13
                    tvEducationPoint.text=" $educationPoint point"
                }
            }

        }

        editor!!.putInt(INDEX, radioGroupEducation.getCheckedRadioButtonId())
        editor!!.putInt(Common.EDUCATION,educationPoint);
        editor!!.apply()
    }

    fun educationPreviousClick(view: View){
        val iEnglish= Intent(applicationContext, AgeActivity::class.java)
        startActivity(iEnglish)
    }

    fun educationNextClick(view: View){
        val iEnglish= Intent(applicationContext, EnglishActivity::class.java)
        startActivity(iEnglish)
    }
}
