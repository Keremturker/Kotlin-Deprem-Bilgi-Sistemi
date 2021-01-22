package com.keremturker.deprembilgisistemi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keremturker.deprembilgisistemi.R
import com.keremturker.deprembilgisistemi.adapter.DepremAdapter
import com.keremturker.deprembilgisistemi.model.Deprem
import com.keremturker.deprembilgisistemi.service.ApiService
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var rv_deprem: RecyclerView
    private val depremApiService = ApiService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_deprem = findViewById(R.id.rvDeprem)
        rv_deprem.layoutManager = LinearLayoutManager(this)

        get_Data()


    }

    fun get_Data() {


        val result = depremApiService.getData()

        result.enqueue(object : retrofit2.Callback<ArrayList<Deprem>> {
            override fun onResponse(
                call: Call<ArrayList<Deprem>>,
                response: Response<ArrayList<Deprem>>
            ) {

                val item = response.body()

                var list_Deprem: ArrayList<Deprem> = ArrayList()

                item?.let {
                    for (i in 0 until item.size) {

                        var deprem = Deprem(
                            item[i].tarih,
                            item[i].saat,
                            item[i].enlem,
                            item[i].boylam,
                            item[i].derinlik,
                            item[i].buyukluk,
                            item[i].yer,
                            item[i].sehir
                        )

                        list_Deprem.add(deprem)


                    }

                }

                rv_deprem.adapter = DepremAdapter(list_Deprem)


            }

            override fun onFailure(call: Call<ArrayList<Deprem>>, t: Throwable) {
                Log.d("test1", t.toString())

            }

        })

    }
}