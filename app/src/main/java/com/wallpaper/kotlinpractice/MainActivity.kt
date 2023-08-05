package com.wallpaper.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    //document design fooundation https://developer.android.com/design/ui/mobile/guides/foundations/system-bars
    //document used ->   https://developer.android.com/develop/ui/views/layout/edge-to-edge#kotlin

    lateinit var floatingActionButton: FloatingActionButton
    lateinit var textView: TextView

    lateinit var  listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //listview
        listView=findViewById(R.id.mylistview)


        //adapter
      val myadapter=MyAdapter(this,generatedata())



        //datasource
        listView.adapter=myadapter







//making app full screen
        WindowCompat.setDecorFitsSystemWindows(window, false)


        floatingActionButton = findViewById(R.id.floatingActionButton);

        textView = findViewById(R.id.textView)

        setview(floatingActionButton)

        setview(textView)

        floatingActionButton.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        }


        //same can be used to remove  operlap  guesture and  system bars with view

    }

    fun generatedata():ArrayList<CountryModel>{
        var result=ArrayList<CountryModel>()

        val country1=CountryModel("INDIA","2",R.drawable.gpt)

        val country2=CountryModel("PAKISTAN","3",R.drawable.aiwriting)
        val country3=CountryModel("MALASIYA","10",R.drawable.imagetext)
        val country4=CountryModel("USA","54",R.drawable.productivewebsite)

        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)

        return  result
    }

    fun setview(view: View) {

        //assigning margin /padding to views to not overlap the system bars and guestre

        ViewCompat.setOnApplyWindowInsetsListener(view) { view,
                                                          windowsInsets ->
            val insets = windowsInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updateLayoutParams<MarginLayoutParams> {
                bottomMargin = insets.bottom
                topMargin=insets.top
            }
            //floatingActionButton.updatePadding(insets.left,insets.top,insets.right,insets.bottom)
            WindowInsetsCompat.CONSUMED

        }
    }
}