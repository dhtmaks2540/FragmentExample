package kr.co.lee.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    lateinit var addOrReplaceBtn: Button
    lateinit var removeBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addOrReplaceBtn = findViewById(R.id.button1)
        removeBtn = findViewById(R.id.button2)

        if(savedInstanceState == null) {
            // FragmentManager를 통해서 FragmentTransaction 획득하기
            val fragmentTransaction: FragmentTransaction =
                supportFragmentManager.beginTransaction()
            // add를 통해 container에 Fragment 추가
            fragmentTransaction.add(R.id.fragment_container, FirstFragment())
            fragmentTransaction.setReorderingAllowed(true)
            // commit을 통해 transaction 등록
            fragmentTransaction.commit()


            // FragmentKTX의 기능을 사용하여 위의 코드를 깔끔하게 변경
            // commit 함수 내부에 FragmentTransaction을 수신객체로 받는
            // 함수 타입이 있어서 아래와 같이 작성 가능
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, FirstFragment())
            }
        }
    }
}