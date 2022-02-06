package com.proj.newer_daang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val toolbar = findViewById<Toolbar>(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.logo_60); //제목앞에 아이콘 넣기
        toolbar.setTitle("뉴어당");


        //bottom bar: onclick intent move
        val btnBookmark = findViewById<ImageButton>(R.id.bottombar_bookmark);
        btnBookmark.setOnClickListener {
            val intentBookmark = Intent(this, BookmarkActivity::class.java)
            startActivity(intentBookmark)
        }

        //


        //category: onclick intent move
        val tvCate_politics = findViewById<TextView>(R.id.cate_politics);
        tvCate_politics.setOnClickListener {
            val intentTermsList = Intent(this, TermsListActivity::class.java)
            intentTermsList.putExtra("category","정치")
            startActivity(intentTermsList)
        }
        val tvCate_social = findViewById<TextView>(R.id.cate_social);
        tvCate_social.setOnClickListener {
            val intentTermsList = Intent(this, TermsListActivity::class.java)
            intentTermsList.putExtra("category","사회")
            startActivity(intentTermsList)
        }
        val tvCate_economy = findViewById<TextView>(R.id.cate_economy);
        tvCate_economy.setOnClickListener {
            val intentTermsList = Intent(this, TermsListActivity::class.java)
            intentTermsList.putExtra("category","경제")
            startActivity(intentTermsList)
        }
        val tvCate_culture = findViewById<TextView>(R.id.cate_culture);
        tvCate_culture.setOnClickListener {
            val intentTermsList = Intent(this, TermsListActivity::class.java)
            intentTermsList.putExtra("category","문화")
            startActivity(intentTermsList)
        }
        val tvCate_military = findViewById<TextView>(R.id.cate_military);
        tvCate_military.setOnClickListener {
            val intentTermsList = Intent(this, TermsListActivity::class.java)
            intentTermsList.putExtra("category","군사")
            startActivity(intentTermsList)
        }
        val tvCate_IT = findViewById<TextView>(R.id.cate_IT);
        tvCate_IT.setOnClickListener {
            val intentTermsList = Intent(this, TermsListActivity::class.java)
            intentTermsList.putExtra("category","IT/과학")
            startActivity(intentTermsList)
        }
        //



    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.func_search, menu)
        return true
    }
}


//main_page




//하단바 액션(시작페이지, 로그인페이지 말고는 모두 등장)
