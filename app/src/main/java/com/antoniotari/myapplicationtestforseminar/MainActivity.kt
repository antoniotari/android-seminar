package com.antoniotari.myapplicationtestforseminar

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.google.gson.Gson
import okhttp3.*
import okio.IOException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val TAG = "antonio"
    }

    private val client = OkHttpClient()
    private val gson = Gson()

    private lateinit var btn: Button
    private lateinit var textView: TextView
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // grab the ui elements from the xml layout
        btn = findViewById(R.id.buttonOne)
        textView = findViewById(R.id.textViewOne)
        textView.text = getString(R.string.newStr)
        img = findViewById(R.id.imageOne)

        // set click listeners where necessary
        btn.setOnClickListener {
            loadImage()
        }
        textView.setOnClickListener(this)

        //example get request
        getRequest()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.buttonOne -> loadImage()
            R.id.textViewOne -> goToActivity2()
        }
    }

    private fun goToActivity2() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    /**
     * getting an image from the web using Glide library
     */
    private fun loadImage() {
        Glide.with(img)
            .load("https://miro.medium.com/max/1100/1*YQgmKR1B9Pf58frRdGqMyA.jpeg")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(img);
    }

    /**
     * once we get a response from the API call we can do something with it, in this example I'm visualizing
     * the name of the colour and applying it to the background
     */
    fun applyResponseToUI(colour: ColourModel) {
        runOnUiThread { // modifications on the ui must happen on the ui thread
            textView.text = colour.colourName
            val mainLayout: LinearLayout = findViewById(R.id.mainLayoutOne)
            Toast.makeText(this,colour.colourName, Toast.LENGTH_LONG).show()
            mainLayout.setBackgroundColor(Color.parseColor(colour.hexValue))
        }
    }

    private fun getRequest() {
        val request = Request.Builder()
            .url("https://random-data-api.com/api/color/random_color")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    // the following block will model the response inside a ColourModel object or throw an exception if the response is null
                    response.body?.let { responseBody ->
                        val responseString = responseBody.string()
                        val colourModel = gson.fromJson(responseString, ColourModel::class.java)
                        applyResponseToUI(colourModel)

                        Log.d(TAG, responseString)
                    } ?: Log.e(TAG, "some connection error might have happened") // TODO: handle error
                } else {
                    Log.e(TAG, "connection unsuccessful") // TODO: handle error
                }
            }
        })
    }
}
