package com.thoughtctlapp.compo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.example.ImgurData
import com.thoughtctlapp.R
import com.thoughtctlapp.util.Utils
import com.thoughtctlapp.viewmodels.MainViewModel
import androidx.compose.foundation.lazy.grid.items as lg
import androidx.compose.foundation.lazy.items as ll

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImgurListContent(innerPadding: PaddingValues, isListSelected: MutableState<Boolean>) {

    val mainViewModel: MainViewModel = hiltViewModel()
    val imgurList: State<List<ImgurData>> = mainViewModel.imgurList.collectAsState()

    if (imgurList.value.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            contentAlignment =
            Alignment.Center
        ) {
            Text(text = "Loading...", fontSize = 30.sp, color = Color.Black)
        }
    } else {
        // Display the list of credit cards
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 10.dp,
                    top = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp
                )

        ) {

            if (isListSelected.value) {

                LazyColumn() {
                    ll(imgurList.value) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .shadow(elevation = 10.dp, RectangleShape)
                                .padding(top = 6.dp)
                                .wrapContentHeight(align = Alignment.Top),

                            shape = CutCornerShape(corner = CornerSize(5.dp)),
                        ) {
                            Box {
                                GlideImage(
                                    model = if (item.images.size > 0) item.images[0].link else "",
                                    loading = placeholder(R.drawable.placeholder),
                                    failure = placeholder(R.drawable.no_image),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "logo",
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(5))
                                        .border(2.dp, color = Color.Black, RoundedCornerShape(5))
                                        .fillMaxSize()
                                        .height(200.dp)
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .align(Alignment.BottomCenter)
                                        .background(color = Color(0x55FFFF00))
                                        .padding(10.dp)
                                ) {
                                    item.title?.let {
                                        Text(
                                            text = it,
                                            color = Color.Black,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            maxLines = 1
                                        )
                                    }
                                    item.datetime?.let {
                                        Text(
                                            text = Utils.getDateTime(it),
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                    }
                                    Text(
                                        text = item.imagesCount.toString(),
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }


                            }


                            // Add a space between items
                        }
                        Spacer(Modifier.padding(5.dp))
                    }
                }
            } else {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(1.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    lg(imgurList.value) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .shadow(elevation = 5.dp, RectangleShape)
                                .padding(5.dp)
                                .wrapContentHeight(align = Alignment.Top),

                            shape = RoundedCornerShape(5),
                        ) {

                            Box {
                                GlideImage(
                                    model = if (item.images.size > 0) item.images[0].link else "",
                                    loading = placeholder(R.drawable.placeholder),
                                    failure = placeholder(R.drawable.no_image),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "logo",
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(5))
                                        .border(2.dp, color = Color.Black, RoundedCornerShape(5))
                                        .height(200.dp)

                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .align(Alignment.BottomCenter)
                                        .background(color = Color(0x55FFFF00))
                                        .padding(10.dp)
                                ) {
                                    item.title?.let {
                                        Text(
                                            text = it,
                                            color = Color.Black,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            maxLines = 1
                                        )
                                    }
                                    item.datetime?.let {
                                        Text(
                                            text = Utils.getDateTime(it),
                                            color = Color.Black,
                                            fontSize = 12.sp
                                        )
                                    }

                                    Text(
                                        text = item.imagesCount.toString(),
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                }
                            }


                        }
                    }
                }
            }

        }
    }

}