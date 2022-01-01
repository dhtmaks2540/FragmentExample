package kr.co.lee.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow

class MainActivity : AppCompatActivity() {

    lateinit var replaceBtn: Button
    lateinit var removeBtn: Button
    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceBtn = findViewById(R.id.button1)
        removeBtn = findViewById(R.id.button2)

        logMessage("onCreate()")

        if (savedInstanceState == null) {
            // commit 메소드(Fragment - ktx 기능 사용)
            fragmentManager.commit {
                setReorderingAllowed(true)
                // 컨테이너에 프래그먼트 추가(태그도 추가)
                add(R.id.fragment_container, FirstFragment(), "firstFragment")
                add(R.id.fragment_container, SecondFragment(), "secondFragment")
                add(R.id.fragment_container, ThirdFragment(), "thirdFragment")
                addToBackStack(null)
            }
        }

        replaceBtn.setOnClickListener {
            val secondFragment = fragmentManager.findFragmentByTag("secondFragment")
            fragmentManager.commit {
                if(secondFragment != null) {
                    // replace 메소드를 사용하여 Fragment 교체
                    replace(R.id.fragment_container, secondFragment)
                }
            }
        }

        removeBtn.setOnClickListener {
            // FragmentManager의 findFragmentByTag 메소드를 이용해 Fragment 찾기
            val secondFragment = fragmentManager.findFragmentByTag("secondFragment")
            fragmentManager.commit {
                if(secondFragment != null) {
                    remove(secondFragment)
                } else {
                    Toast.makeText(this@MainActivity,
                        "SecondFragment가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        logMessage("onStart")
    }

    override fun onResume() {
        super.onResume()
        logMessage("onResume")
    }

    override fun onPause() {
        super.onPause()
        logMessage("onPause")
    }

    override fun onStop() {
        super.onStop()
        logMessage("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logMessage("onDestroy")
    }


    private fun logMessage(message: String) {
        Log.i("MainActivity", "수명주기메소드 : $message")
    }
}