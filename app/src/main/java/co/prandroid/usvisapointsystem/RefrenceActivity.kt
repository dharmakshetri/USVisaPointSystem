package co.prandroid.usvisapointsystem

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RefrenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refrence)
    }
    fun billClick(view: View){
        val uri = Uri.parse("https://www.cotton.senate.gov/files/documents/170802_New_RAISE_Act_Bill_Text.pdf")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun cnnClick(view: View){
        val uri = Uri.parse("http://www.cnn.com/2017/08/02/politics/cotton-perdue-trump-bill-point-system-merit-based/index.html")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun bbcClick(view: View){
        val uri = Uri.parse("http://www.bbc.com/news/world-us-canada-40814625f")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun nytimesClick(view: View){
        val uri = Uri.parse("https://www.nytimes.com/2017/03/01/us/politics/immigration-trump.html")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    fun nbcClick(view: View){
        val uri = Uri.parse("http://www.nbcnews.com/politics/white-house/trump-backs-slashing-legal-immigration-merit-based-system-n788816")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun abcClick(view: View){
        val uri = Uri.parse("http://abcnews.go.com/Politics/trump-aims-cut-legal-immigration-legislation/story?id=48985055")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun guardianClick(view: View){
        val uri = Uri.parse("https://www.theguardian.com/us-news/2017/aug/03/donald-trump-immigration-plan-australian-points-system")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun refPreviousClick(view: View){
        val iJob= Intent(applicationContext, FinalResultActivity::class.java)
        startActivity(iJob)
    }


}
