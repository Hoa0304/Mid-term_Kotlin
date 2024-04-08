package com.example.a22teb021_tranthicamhoa

import android.R
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.a22teb021_tranthicamhoa.databinding.ActivityQlhpBinding

class QLHP : AppCompatActivity() {
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var binding: ActivityQlhpBinding
    lateinit var cusAdap: CusAdap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQlhpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.qlai.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        var helpers = Helpers(applicationContext)
        db = helpers.readableDatabase
        rs = db.rawQuery("SELECT * FROM HPhan LIMIT 20", null)
        var text = ""
        var list = mutableListOf<Data>()
       try {
           while (rs.moveToNext()){
              list.add(Data(rs.getString(0).toString(), rs.getString(1).toString()))
           }
       }catch (x :Exception){
           println(x)
       }
          cusAdap = CusAdap(this, list)
//        adapter =SimpleCursorAdapter(applicationContext, android.R.layout.simple_expandable_list_item_2, rs,
//            arrayOf("mahp","ten"), intArrayOf(android.R.id.text1, android.R.id.text2), 0)
        binding.lv.adapter = cusAdap
        binding.viewall.setOnClickListener {
            binding.searchv.visibility = View.VISIBLE
            binding.lv.visibility = View.VISIBLE
            binding.searchv.queryHint = "Tìm kiếm trong ${rs.count} bản ghi"
        }
        binding.searchv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
                rs = db.rawQuery("SELECT * FROM HPhan WHERE ten LIKE '%${newText}'", null)
                cusAdap.notifyDataSetChanged()
                return true
            }
        })
        binding.add.setOnClickListener {
            var cv = ContentValues()
            cv.put("mahp", binding.mahp.text.toString())
            cv.put("ten", binding.tenhp.text.toString())
            cv.put("sotin", binding.sotc.toString())
            cv.put("hk", binding.hk.toString())
            db.insert("HPhan", null, cv)
            rs.requery()
            cusAdap.notifyDataSetChanged()
            var ad = AlertDialog.Builder(this)
            ad.setTitle("Add record")
            ad.setMessage("Add thanh cong")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, which ->
                binding.mahp.setText("")
                binding.sotc.setText("")
                binding.tenhp.setText("")
                binding.hk.setText("")
            })
            ad.show()
            binding.lv.removeAllViewsInLayout()
            binding.lv.adapter = cusAdap
        }
        binding.lv.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView,view, i, l ->
            binding.mahp.setText(list[i].mahp)
            binding.tenhp.setText(list[i].ten)

        }
          binding.delete.setOnClickListener {
              db.delete("HPhan", "mahp=${binding.mahp.text.toString()}", arrayOf(rs.getString(0)))
              rs.requery()
          }
    }

}