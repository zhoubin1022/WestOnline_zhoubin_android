package com.example.west2chat


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val itemList:List<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val LEFT=1
        const val RIGHT=2
    }

    inner class LeftViewHolder(view: View):RecyclerView.ViewHolder(view){
        val groupImageLeft:ImageView=view.findViewById(R.id.groupImage_left)
        val groupNameLeft:TextView=view.findViewById(R.id.groupName_left)
        val creatorNameLeft:TextView=view.findViewById(R.id.creatorName_left)
    }
    inner class RightViewHolder(view: View):RecyclerView.ViewHolder(view){
        val groupImageRight:ImageView=view.findViewById(R.id.groupImage_right)
        val groupNameRight:TextView=view.findViewById(R.id.groupName_right)
        val creatorNameRight:TextView=view.findViewById(R.id.creatorName_right)
    }

    override fun getItemViewType(position: Int): Int {
        return if(position%2==0) LEFT
        else RIGHT
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder{
        return if(viewType== LEFT){
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item_left,parent,false)
            LeftViewHolder(view)
        }else{
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item_right,parent,false)
            RightViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item= Data.itemList[position]
        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("extra_data",item)
            holder.itemView.context.startActivity(intent)
        }
        when(holder) {
            is LeftViewHolder-> {
                holder.groupImageLeft.setImageResource(item.GroupImageId)
                holder.groupNameLeft.text=item.GroupName
                holder.creatorNameLeft.text=item.CreatorName
            }
            is RightViewHolder-> {
                holder.groupImageRight.setImageResource(item.GroupImageId)
                holder.groupNameRight.text=item.GroupName
                holder.creatorNameRight.text=item.CreatorName
            }
        }
    }
    override fun getItemCount()=itemList.size
}