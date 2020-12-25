package com.example.west2chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val extraData= intent.getSerializableExtra("extra_data") as Item
        val groupName:String=extraData.GroupName
        val creatorName:String=extraData.CreatorName
        val groupImageId:Int=extraData.GroupImageId

        groupImage_detail.setImageResource(groupImageId)
        groupName_detail.text=groupName
        creatorName_detail.text=creatorName
    }
}                                                       