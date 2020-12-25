package com.example.west2chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.west2chat.Data.itemList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //相邻的列表Item不同。
    //private val itemList=ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager=LinearLayoutManager(this)
        recyclerview.layoutManager=layoutManager
        val adapter=ItemAdapter(itemList)
        recyclerview.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.operater_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addItem ->{
                val intent=Intent(this,AddActivity::class.java)
                startActivityForResult(intent,1)
            }
            R.id.clearItem->{
                itemList.clear()
                recyclerview.adapter?.notifyDataSetChanged()
                Toast.makeText(this,"all clear",Toast.LENGTH_LONG).show()
            }
            R.id.exitItem ->{
                this.finish()
                Toast.makeText(this,"exit!!",Toast.LENGTH_LONG).show()
            }
            else->{
                Toast.makeText(this,"wrong operate",Toast.LENGTH_LONG).show()
            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if(resultCode== RESULT_OK){
                Toast.makeText(this,"you add an item.1",Toast.LENGTH_LONG).show()
                val returnedData:Item=data?.getSerializableExtra("data_return") as Item
                Toast.makeText(this,"you add an item.2",Toast.LENGTH_LONG).show()
                itemList.add(0,returnedData)
                Toast.makeText(this,"you add an item.",Toast.LENGTH_LONG).show()
                recyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }
}