package com.example.kotlincomposenewapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kotlincomposenewapp.R
import com.example.kotlincomposenewapp.data.entity.Article
import com.example.kotlincomposenewapp.data.entity.NewsResponse
import com.example.kotlincomposenewapp.ui.theme.Purple40

@Composable

fun Loader(){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn{
        items(response.articles){ article ->
            NormalTextComponent(textValue = article.title ?: "NA")
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40
        )
    )
}
@Composable
fun DescTextComponent(textValue: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Color.Blue
        )
    )
}
@Composable
fun HeadingTextComponent(textValue: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
    )
}

@Composable
fun AuthorDetailSComponent(authorName: String?, sourceName: String?) {
    Row (modifier = Modifier.fillMaxWidth()
        .padding(start = 10.dp, end = 10.dp)
    ){
            authorName?.also {
                NormalTextComponent(textValue = it)
            }
        Spacer(modifier = Modifier.weight(1f))
        sourceName?.also {
            NormalTextComponent(textValue = it)
        }
    }
}

@Composable
fun NewsRowComponent(page:Int, article: Article){
    Column (   modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .background(Color.White)) {
     AsyncImage(
         modifier = Modifier
             .fillMaxWidth()
             .height((240.dp)),
         model = article.urlToImage,
         contentDescription = "",
         contentScale = ContentScale.Crop,
         placeholder = painterResource(id = R.drawable.bepo)
         )

        Spacer(modifier = Modifier.size(20.dp))
        
        HeadingTextComponent(textValue = article.title?:"")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.content?:"")
        Spacer(modifier = Modifier.size(10.dp))
        DescTextComponent(textValue = article.description?:"")
        Spacer(modifier = Modifier.weight(1f))
        AuthorDetailSComponent(article.author, article.source?.name)
    }
}

@Preview
@Composable
fun NewsRowComponentPreview(){
    val article = Article(
        author = "Mock",
        title = "This is a mock news article",
        null,
        null,
        null,
        null,
        null,
        null
    )

    NewsRowComponent(page = 0, article )
}