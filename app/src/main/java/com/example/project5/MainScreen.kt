package com.example.project5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
//    Variabel untuk FieldText
    var nama by rememberSaveable { mutableStateOf("")}
    var email by rememberSaveable { mutableStateOf("")}
    var alamat by rememberSaveable { mutableStateOf("")}
    var noHP by rememberSaveable { mutableStateOf("")}
    var selectGender by rememberSaveable { mutableStateOf("")}
    
//    Variabel untuk Radio Button
    val jenisKelamin = listOf("Laki-Laki", "Perempuan")
    
//    Variabel untuk Confirm
    var confirmnama by rememberSaveable { mutableStateOf("")}
    var confirmemail by rememberSaveable { mutableStateOf("")}
    var confirmalamat by rememberSaveable { mutableStateOf("")}
    var confirmnoHP by rememberSaveable { mutableStateOf("")}
    var confirmselectGender by rememberSaveable { mutableStateOf("")}
    
    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text(text = "Nama Lengkap")},
            label = { Text(text = "Nama")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Row() {
            jenisKelamin.forEach { item -> Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = selectGender == item , onClick = { /*TODO*/
                selectGender = item})
                Text(text = item)
            } }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text(text = "Masukan Email")},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text(text = "Masukan Alamat Lengkap")},
            label = { Text(text = "Alamat")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text(text = "Masukan Nomor Telepon")},
            label = { Text(text = "Nomor HandPhone")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Button(onClick = {
            confirmnama = nama
            confirmselectGender = selectGender
            confirmemail = email
            confirmalamat = alamat
            confirmnoHP = noHP
        }) {
            Text(text = "Simpan")
        }

        Card(
            modifier
                .fillMaxWidth()
                .padding(5.dp)) {
            MainSection(judulParam = "Nama", isipParam = confirmnama )
            MainSection(judulParam = "Jenis Kelamin", isipParam = confirmselectGender )
            MainSection(judulParam = "Email", isipParam = confirmemail )
            MainSection(judulParam = "Alamat", isipParam = confirmalamat )
            MainSection(judulParam = "Nomor Hp", isipParam = confirmnoHP )
        }
    }
}

@Composable
fun MainSection(judulParam:String, isipParam:String){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = judulParam, Modifier.weight(0.8f))
            Text(text = ":", Modifier.weight(0.2f))
            Text(text = isipParam, Modifier.weight(2f))
        }
    }
}
