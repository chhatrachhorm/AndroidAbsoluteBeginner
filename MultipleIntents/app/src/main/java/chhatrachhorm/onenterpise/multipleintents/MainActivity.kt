package chhatrachhorm.onenterpise.multipleintents

import android.app.ProgressDialog
import android.content.Intent
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mGoBtn: Button? = null
    private var mPageNumber: TextInputEditText? = null
    private var mProgressDiaglog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mGoBtn = findViewById<Button>(R.id.main_go_btn)
        mPageNumber = findViewById<TextInputEditText>(R.id.main_navigator)
        mProgressDiaglog = ProgressDialog(this@MainActivity)
// double bang !! will throw null pointer exception if it's null
        mGoBtn!!.setOnClickListener {
            mProgressDiaglog!!.setTitle("Checking Number")
            mProgressDiaglog!!.setMessage("This may take a couple second")
            mProgressDiaglog!!.setCanceledOnTouchOutside(false)
            mProgressDiaglog!!.show()
            if (!mPageNumber!!.editableText.toString().isEmpty()) {
                val pageNum = Integer.parseInt(mPageNumber!!.editableText.toString())
                mProgressDiaglog!!.dismiss()
                when (pageNum) {
                    1 -> startActivity(Intent(this@MainActivity, Act1Activity::class.java))
                    2 -> startActivity(Intent(this@MainActivity, Act2Activity::class.java))
                    3 -> startActivity(Intent(this@MainActivity, Act3Activity::class.java))
                    4 -> startActivity(Intent(this@MainActivity, Act4Activity::class.java))
                    else -> Toast.makeText(this@MainActivity, "Please input number from 1-4 only", Toast.LENGTH_LONG).show()
                }
            } else
                mProgressDiaglog!!.dismiss()
                Toast.makeText(this@MainActivity, "Please input some number from 1-4 only", Toast.LENGTH_LONG).show()
        }


    }
}
