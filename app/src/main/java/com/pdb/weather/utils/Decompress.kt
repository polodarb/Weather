package com.pdb.weather.utils

import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

class Decompress(private val zip: String, private val loc: String) {
    fun unzip() {
        try {
            val fin = FileInputStream(zip)
            val zin = ZipInputStream(fin)
            var ze: ZipEntry? = null
            while (zin.nextEntry.also { ze = it } != null) {
                Log.v("Decompress", "Unzipping " + ze?.name)
                if (ze?.isDirectory == true) {
                    dirChecker(ze?.name.toString())
                } else {
                    val fout = FileOutputStream(loc + ze?.name)
                    var c: Int = zin.read()
                    while (c != -1) {
                        fout.write(c)
                        c = zin.read()
                    }
                    zin.closeEntry()
                    fout.close()
                }
            }
            zin.close()
        } catch (e: Exception) {
            Log.e("Decompress", "unzip", e)
        }
    }

    private fun dirChecker(dir: String) {
        val f = File("city_list" + dir) //    File f = new File(_location.toString() + dir); ???
        if (!f.isDirectory()) {
            f.mkdirs()
        }
    }

    init {
        dirChecker("")
    }
}