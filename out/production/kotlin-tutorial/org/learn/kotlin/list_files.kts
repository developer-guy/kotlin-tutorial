import java.io.File
/* this class is similar example of kotlin script file */
val folders = File(args[0]).listFiles { file ->
    file.isDirectory()
}

folders?.forEach { folder ->
    println(folder)
}