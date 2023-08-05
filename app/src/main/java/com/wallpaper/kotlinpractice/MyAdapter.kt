package com.wallpaper.kotlinpractice

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(private val activity: Activity,private val item:ArrayList<CountryModel>):BaseAdapter() {

    override fun getCount(): Int {
        return item.size
    }

    override fun getItem(position: Int): CountryModel {
       return item[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


//this method generate item fot the listview
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
val view:View?
val viewHolder:ViewHolder

if(convertView == null){
val inflater=activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    view=inflater.inflate(R.layout.custom_layout,null)
    viewHolder=ViewHolder(view)
    view?.tag=viewHolder
}else{
    view=convertView
    viewHolder=view.tag as ViewHolder
}
    var countries=item[position]

    viewHolder.textView?.text=countries.name
    viewHolder.cupswins?.text=countries.cupwins
    viewHolder.Imagecountry?.setImageResource(countries.imageid)


    view?.setOnClickListener {
        Toast.makeText(activity,"You choose ${countries.name}",Toast.LENGTH_LONG).show()
    }

    return view as View
    }

    private class ViewHolder( row:View?){
        var textView:TextView?=null
        var cupswins:TextView?=null

        var Imagecountry:ImageView?=null

        init{
            this.textView=row?.findViewById(R.id.countryname)
            this.cupswins=row?.findViewById(R.id.countrywins);
            this.Imagecountry=row?.findViewById(R.id.countryimage)
        }


    }


}