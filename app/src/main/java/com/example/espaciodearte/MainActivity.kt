package com.example.espaciodearte

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.espaciodearte.ui.theme.EspacioDeArteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EspacioDeArteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppEspacioArte()
                }
            }
        }
    }
}

@Composable
fun AppEspacioArte(modifier: Modifier = Modifier) {
    val primero = R.drawable.cdmx
    val segundo = R.drawable.morelia
    val tercero = R.drawable.allende
    val cuarto = R.drawable.catrina

    var titulo by remember { mutableStateOf(R.string.texto_titulo_cdmx) }
    var anno by remember { mutableStateOf(R.string.texto_anno_cdmx) }
    var obraArte by remember { mutableStateOf(primero) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VisualizadorObrasdeArte(modifier = Modifier.fillMaxWidth(), obraArte = obraArte)
        Spacer(modifier = Modifier.size(10.dp))
        TituloEspacioArte(titulo = titulo, anno = anno)
        Spacer(modifier = Modifier.size(25.dp))
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Button(
                onClick = {
                    obraArte = when (obraArte) {
                        primero -> {
                            titulo = R.string.texto_titulo_catrina
                            anno = R.string.texto_anno_catrina
                            cuarto
                        }
                        segundo -> {
                            titulo = R.string.texto_titulo_cdmx
                            anno = R.string.texto_anno_cdmx
                            primero
                        }
                        tercero -> {
                            titulo = R.string.texto_titulo_morelia
                            anno = R.string.texto_anno_morelia
                            segundo
                        }
                        else -> {
                            titulo = R.string.texto_titulo_allende
                            anno = R.string.texto_anno_allende
                            tercero
                        }
                    }
                }
            ){
                Text(
                    text = "Anterior",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Green
                )
            }
            Button(
                onClick = {
                    obraArte = when (obraArte) {
                        primero -> {
                            titulo = R.string.texto_titulo_morelia
                            anno = R.string.texto_anno_morelia
                            segundo
                        }
                        segundo -> {
                            titulo = R.string.texto_titulo_allende
                            anno = R.string.texto_anno_allende
                            tercero
                        }
                        tercero -> {
                            titulo = R.string.texto_titulo_catrina
                            anno = R.string.texto_anno_catrina
                            cuarto
                        }
                        else -> {
                            titulo = R.string.texto_titulo_cdmx
                            anno = R.string.texto_anno_cdmx
                            primero
                        }
                    }
                }
            ){
                Text(
                    text = "Siguiente",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Green
                )
            }
        }
    }
}


@Composable
fun Modifier.buttonStyle(): Modifier {
    return this.then(
        Modifier
            .background(color = colorResource(id = R.color.gray_900))
            .defaultMinSize(minWidth = 120.dp)
            .padding(8.dp)
    )
}

@Composable
fun VisualizadorObrasdeArte(
    modifier: Modifier = Modifier,
    @DrawableRes obraArte: Int
) {
    Image(
        painter = painterResource(obraArte),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun TituloEspacioArte(
    @StringRes titulo: Int,
    @StringRes anno: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = titulo),
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFF6F00),
            fontSize = 32.sp
        )
        Text(
            text = stringResource(id = anno),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF212121)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EspacioDeArteTheme {
        AppEspacioArte()
    }
}
