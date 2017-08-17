package co.prandroid.usvisapointsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_age.*
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd


import com.google.android.gms.ads.MobileAds



class AgeActivity : AppCompatActivity() {

    internal lateinit var mInterstitialAd: InterstitialAd
    internal lateinit var adRequest : AdRequest
    var agePoint:Int=0

    var sharedPref:SharedPreferences? = null
    var  editor: SharedPreferences.Editor? = null
    val INDEX:String = "ageindex"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)

        MobileAds.initialize(this, resources.getString(R.string.app_id));

        sharedPref=getSharedPreferences(Common.MY_PREF, Context.MODE_PRIVATE)
        val ageIndex= sharedPref!!.getInt(INDEX, 110)
        agePoint=sharedPref!!.getInt(Common.AGE,0)

        editor = sharedPref!!.edit()
        radioGroupAge.check(ageIndex)
        tvAgePoint.text=" $agePoint point"

        mInterstitialAd =  InterstitialAd(this)
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        requestNewInterstitial()

    }
    // [START request_new_interstitial]
    private fun requestNewInterstitial() {
         adRequest = AdRequest.Builder().build()
         mInterstitialAd.loadAd(adRequest)
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.lessthan18 -> {
                if (checked){
                    agePoint=0
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.eighteento21 -> {
                if (checked){
                    agePoint=6
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.twentyto25 -> {
                if (checked){
                    agePoint=8
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.twenty26to30 -> {
                if (checked){
                    agePoint=10
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.thirty1to35 -> {
                if (checked){
                    agePoint=8
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.thirty36to40 -> {
                if (checked){
                    agePoint=6
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.fouty1to45 -> {
                if (checked){
                    agePoint=4
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.fouty6to50 -> {
                if (checked){
                    agePoint=2
                    tvAgePoint.text=" $agePoint point"

                }
            }
            R.id.fiftyplus -> {
                if (checked){
                    agePoint=0
                    tvAgePoint.text=" $agePoint point"

                }
            }

        }
        editor!!.putInt(INDEX, radioGroupAge.getCheckedRadioButtonId())
        editor!!.putInt(Common.AGE,agePoint);
        editor!!.apply()
    }

    fun ageNextClick(view: View){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            beginSecondActivity();
        }

        // [START create_interstitial_ad_listener]
        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                requestNewInterstitial()
                beginSecondActivity()
            }

            override fun onAdLoaded() {
                // Ad received, ready to display
                // [START_EXCLUDE]
                /*if (mLoadInterstitialButton != null) {
                    mLoadInterstitialButton.setEnabled(true)
                }*/
                // [END_EXCLUDE]
            }

            override fun onAdFailedToLoad(i: Int) {
                Log.w("AgeActivity", "onAdFailedToLoad:" + i)
            }
        }
        // [END create_interstitial_ad_listener]
    }

    private fun beginSecondActivity() {
        val iAge= Intent(applicationContext, EducationActivity::class.java)
        startActivity(iAge)
    }
}






