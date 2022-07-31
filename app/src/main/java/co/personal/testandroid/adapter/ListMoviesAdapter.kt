package co.personal.testandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import co.personal.testandroid.R
import co.personal.testandroid.model.Movie
import co.personal.testandroid.utils.BASE_IMAGE
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog

class ListMoviesAdapter(context: Context, data: Movie): RecyclerView.Adapter<ListMoviesAdapter.ViewHolder>(){

    var data: Movie? = null
    var context: Context? = null
    var mFragmentManager: FragmentManager? = null

    init {
        this.data = data
        this.context = context
        this.mFragmentManager = mFragmentManager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMoviesAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.data_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvMovieName.text = data!!.results?.get(position)?.title

        Glide.with(context!!)
                .load(BASE_IMAGE + data!!.results?.get(position)?.backdrop_path)
                .centerCrop()
                .placeholder(R.drawable.imageempty)
                .into(holder.imgListCredential)

        holder.cardViewMovies.setOnClickListener {
                val view: View = (context as FragmentActivity).layoutInflater.inflate(R.layout.bottom_sheet_detail_movie, null)
                val dialog = BottomSheetDialog(context!!, R.style.BottomSheetDialogThme)
                dialog.setContentView(view)

                val imageMovie = view.findViewById<View>(R.id.imgDetailMovie)
                val detailMovie =  view.findViewById<View>(R.id.txvDetailMovie) as TextView
                val buttonClose =  view.findViewById<View>(R.id.buttonClose) as Button
                val txvAverage = view.findViewById<View>(R.id.txvAverage) as TextView
                val txvDate = view.findViewById<View>(R.id.txvDate) as TextView
                val txvPopulate = view.findViewById<View>(R.id.txvPopulate) as TextView

                detailMovie.text =  data!!.results?.get(position)?.overview

                txvAverage.text = context!!.getString(R.string.label_average) + " " +data!!.results?.get(position)?.vote_count.toString()
                txvDate.text = context!!.getString(R.string.label_date) + " " +data!!.results?.get(position)?.release_date.toString()
                txvPopulate.text = context!!.getString(R.string.label_populate) + " " +data!!.results?.get(position)?.popularity.toString()

                Glide.with(context!!)
                        .load(BASE_IMAGE + data!!.results?.get(position)?.poster_path)
                        .centerCrop()
                        .placeholder(R.drawable.imageempty)
                        .into(imageMovie as ImageView)

                buttonClose.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return data!!.results?.size!!
    }

    fun clear(){
        data!!.results!!.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvMovieName: TextView = itemView.findViewById<View>(R.id.txvMovieName) as TextView
        var imgListCredential: ImageView = itemView.findViewById<View>(R.id.imgMovie) as ImageView
        var cardViewMovies: CardView = itemView.findViewById<View>(R.id.cardViewMovies) as CardView
    }
}