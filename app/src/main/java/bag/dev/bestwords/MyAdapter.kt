package bag.dev.bestwords

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var context: Context, private var items:ArrayList<IdeasStructure>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        var mainText:TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewItem = LayoutInflater.from(context).inflate(R.layout.rc_item,parent,false)
        return MyViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        var str = item.text
        if(str.length>20) str = str.substring(0,45)+"..."
        holder.mainText.text=str

        holder.itemView.setOnClickListener{
            val intent = Intent(context, CheckTextActivity::class.java).apply{
                putExtra("text",item.text)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateAdapter(list:ArrayList<IdeasStructure>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }


}
