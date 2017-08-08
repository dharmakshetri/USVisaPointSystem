package co.prandroid.usvisapointsystem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_spouses.*


class SpousesActivity : AppCompatActivity() {
    internal lateinit var mInterstitialAd: InterstitialAd
    internal lateinit var adRequest : AdRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spouses)


        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        mInterstitialAd =  InterstitialAd(this)
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        requestNewInterstitial()

    }

    // [START request_new_interstitial]
    private fun requestNewInterstitial() {
        adRequest = AdRequest.Builder().build()
        mInterstitialAd.loadAd(adRequest)
    }

    fun spousesPreviousClick(view: View){
        val iJob= Intent(applicationContext, InvesterActivity::class.java)
        startActivity(iJob)
    }

    fun spousesSkipClick(view: View){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            println("show ads")
        } else {
            println("go to next activity")
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
                // See https://goo.gl/sCZj0H for possible error codes.
                Log.w("AgeActivity", "onAdFailedToLoad:" + i)
            }
        }
        // [END create_interstitial_ad_listener]
    }

    fun spousesNextClick(view: View){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            println("show ads")
        } else {
            println("go to next activity")
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
                // See https://goo.gl/sCZj0H for possible error codes.
                Log.w("AgeActivity", "onAdFailedToLoad:" + i)
            }
        }
        // [END create_interstitial_ad_listener]

    }

    private fun beginSecondActivity() {
        val ifinal= Intent(applicationContext, FinalResultActivity::class.java)
        startActivity(ifinal)
    }
}
