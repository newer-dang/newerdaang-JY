package com.proj.newer_daang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class TermsListActivity : AppCompatActivity() {

    lateinit var termAdapter: TermAdapter
    lateinit var termAdapter_category: TermAdapter_category
    val terms = mutableListOf<TermData>()
    val categories = mutableListOf<TermAdapter_category.CateData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termslist)

        val pressed_category = intent.getStringExtra("category")
        val cates = listOf("정치", "사회", "경제","문화","군사","IT/과학")

        /*

        val tv_cates = listOf(findViewById<TextView>(R.id.label_politics), findViewById<TextView>(R.id.label_social), findViewById<TextView>(R.id.label_economy),
                findViewById<TextView>(R.id.label_culture), findViewById<TextView>(R.id.label_military), findViewById<TextView>(R.id.label_IT))
        for(i in cates.indices){
            if(pressed_category.equals(cates[i])){
                tv_cates[i].setBackgroundResource(R.drawable.aqua_darker_background_round)
            }

        }
        */

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.logo_60) //제목앞에 아이콘 넣기
        toolbar.setTitle("카테고리")


        //bottom bar: onclick intent move
        val btnHome = findViewById<ImageButton>(R.id.bottombar_home)
        btnHome.setOnClickListener {
            val intentHome = Intent(this, MainActivity::class.java)
            startActivity(intentHome)
        }
        val btnBookmark = findViewById<ImageButton>(R.id.bottombar_bookmark)
        btnBookmark.setOnClickListener {
            val intentBookmark = Intent(this, BookmarkActivity::class.java)
            startActivity(intentBookmark)
        }

        val recyclerView_termsList = findViewById<RecyclerView>(R.id.recyclerView)
        termAdapter = TermAdapter(this)
        recyclerView_termsList.adapter = termAdapter
        recyclerView_termsList.addItemDecoration(VerticalItemDecorator_rv(5))
        recyclerView_termsList.addItemDecoration(HorizontalItemDecorator_rv(5))
        termAdapter.setOnItemClickListener(object: TermAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: TermData, pos: Int) {


                Toast.makeText( App.ApplicationContext(), "용어목록에서 용어 상세 설명 페이지로 전환됩니다.", Toast.LENGTH_SHORT ).show()
                /*
                Intent(this@MainActivity, ProfileDetailActivity::class.java).apply {
                    putExtra("data", data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
                 */
            }
        })

        terms.apply {
            add(TermData( name = "용어1입니다", meaning = "sampletext"))
            add(TermData( name = "term_sample_length_check", meaning = "sampletext"))
            add(TermData( name = "term_sample", meaning = "sampletext"))
            add(TermData( name = "term_sample_length_check", meaning = "sampletext"))
            add(TermData( name = "term_sample", meaning = "sampletext"))
            add(TermData( name = "term_sample_length_check", meaning = "sampletext"))
            add(TermData( name = "term_sample", meaning = "sampletext"))
            add(TermData( name = "term_sample_length_check", meaning = "sampletext"))
            termAdapter.termsList = terms
            termAdapter.notifyDataSetChanged()

        }


        //initRecycler()

        /*

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_termsList.setLayoutManager(layoutManager)
        //val menuAdapter = MenuAdapter(menuArrayList,this)
        */



        val recyclerView_category = findViewById<RecyclerView>(R.id.recyclerView_category)
        termAdapter_category = TermAdapter_category(this)
        recyclerView_category.adapter = termAdapter_category
        recyclerView_category.addItemDecoration(VerticalItemDecorator_rv(5))
        recyclerView_category.addItemDecoration(HorizontalItemDecorator_rv(5))
        termAdapter_category.setOnItemClickListener(object: TermAdapter_category.OnItemClickListener{
            override fun onItemClick(v: View, data: TermAdapter_category.CateData, pos: Int) {


                Toast.makeText( App.ApplicationContext(), "용어목록에서 용어 상세 설명 페이지로 전환됩니다.", Toast.LENGTH_SHORT ).show()
                /*
                Intent(this@MainActivity, ProfileDetailActivity::class.java).apply {
                    putExtra("data", data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
                 */
            }
        })

        categories.apply {
            add(TermAdapter_category.CateData(name = "정치"))
            add(TermAdapter_category.CateData( name = "사회"))
            add(TermAdapter_category.CateData( name = "군사"))
            add(TermAdapter_category.CateData( name = "문화"))
            add(TermAdapter_category.CateData( name = "경제"))
            add(TermAdapter_category.CateData( name = "IT/과학"))
            termAdapter_category.cateList = categories
            termAdapter_category.notifyDataSetChanged()

        }










    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.func_search, menu)
        return true
    }
}

//terms_list_page (by category)

