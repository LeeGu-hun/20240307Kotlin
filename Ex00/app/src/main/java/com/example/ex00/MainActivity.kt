package com.example.ex00

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ex00.ui.theme.Ex00Theme

class MainActivity : ComponentActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        /*if (v?.id == R.id.button) callz(this)
        else if(v?.id == R.id.textView) callz(this)*/

        when (v?.id) {
            R.id.button -> callz(this)
            R.id.textView -> callz(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // xml로 액티비티를 생성할 때 객체 R에 자동 등록
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        /*button.setOnClickListener(
            View.OnClickListener(
                fun(it: View) {
                    callz(this@MainActivity)
                }
            )
        )*/

        // SAM(single abstract method) 인터페이스를 간단하게 사용 위한 기법
//        button.setOnClickListener {
//            callz(this@MainActivity)
//        }

//        button.setOnClickListener(MyEventHandler(this))
//        textView.setOnClickListener(MyEventHandler(this))
        button.setOnClickListener(this)
        textView.setOnClickListener(this)

        // setContent는 순수하게 자바 소스코드로 액티비티를 생성할 때
        /*setContent {
            Ex00Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }*/
    }
}

fun callz(mainActivity: MainActivity): Unit {
    Log.d(">>", "onClicked")
    Toast.makeText(mainActivity, "Hello", Toast.LENGTH_LONG).show()
    val textView = mainActivity.findViewById<TextView>(R.id.textView)
    textView.setText("you clicked")
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ex00Theme {
        Greeting("Android")
    }
}

class MyEventHandler : View.OnClickListener {
    var mainActivity:MainActivity?
    constructor(mainActivity: MainActivity?) {
        this.mainActivity = mainActivity
    }
    override fun onClick(v: View?) {
        /*if (v?.id == R.id.button) callz(mainActivity as MainActivity)
        else if(v?.id == R.id.textView) callz(mainActivity as MainActivity) */

        when (v?.id) {
            R.id.button -> callz(mainActivity as MainActivity)
            R.id.textView -> callz(mainActivity as MainActivity)
        }
    }
}