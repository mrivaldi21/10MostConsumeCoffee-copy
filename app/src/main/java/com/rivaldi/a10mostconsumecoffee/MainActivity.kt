package com.rivaldi.a10mostconsumecoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvCoffe: RecyclerView
    private val list = ArrayList<Coffe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCoffe = findViewById(R.id.rv_coffe)
        rvCoffe.setHasFixedSize(true)

        list.addAll(getListCoffe())
        showRecycleList()
    }

    private fun showRecycleList() {
        rvCoffe.layoutManager = LinearLayoutManager(this)
        val listCoffeAdapter = ListCoffeAdapter(list)
        rvCoffe.adapter = listCoffeAdapter

        listCoffeAdapter.setOnItemClickCallback(object : ListCoffeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Coffe) {
                showSelectedCoffe(data)
            }
        })
    }

    //Get data and displayed to View
    private fun getListCoffe(): ArrayList<Coffe> {
        val dataName = resources.getStringArray(R.array.data_coffe)
        val dataDescription = resources.getStringArray(R.array.coffe_description)
        val dataPhoto = resources.getStringArray(R.array.coffe_photo)
        val listCoffe = ArrayList<Coffe>()
        //Loop to get each data
        for (i in dataName.indices) {
            val coffe = Coffe(dataName[i], dataDescription[i], dataPhoto[i])
            listCoffe.add(coffe)
        }
        return listCoffe
    }

    //What happen when item is selected
    private fun showSelectedCoffe(coffe: Coffe) {
        //make toast first then later can be changed to new intent
        Toast.makeText(this, "You selected: " + coffe.name, Toast.LENGTH_SHORT).show()
    }

    //List interface Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Change list interface when view menu is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
//            R.id.action_list -> {
//                rvCoffe.layoutManager = LinearLayoutManager(this)
//            }
//
//            R.id.action_grid -> {
//                rvCoffe.layoutManager = GridLayoutManager(this, 2)
//            }

            R.id.about_page -> {
                val moveToAbout = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}