package kr.co.lee.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    lateinit var addOrReplaceBtn: Button
    lateinit var removeBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addOrReplaceBtn = findViewById(R.id.button1)
        removeBtn = findViewById(R.id.button2)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, FirstFragment(), "first")
        }

        addOrReplaceBtn.setOnClickListener {
            replaceFragment()
        }

        removeBtn.setOnClickListener {
            removeFragment()
        }
    }

    private fun replaceFragment() {
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            addToBackStack(null)
//            replace(R.id.fragment_container, FirstFragment(), "first")
//        }

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(R.id.fragment_container, SecondFragment(), "second")
        }
    }

    private fun removeFragment() {
        val fragment = supportFragmentManager.findFragmentByTag("first")
        supportFragmentManager.commit {
            fragment?.let {
                remove(fragment)
                return
            }

            Toast.makeText(this@MainActivity, "No ${fragment?.tag}", Toast.LENGTH_SHORT).show()
        }
    }
}