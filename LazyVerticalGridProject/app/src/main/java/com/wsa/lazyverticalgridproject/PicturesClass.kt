package com.wsa.lazyverticalgridproject

data class PicturesClass(
    val picture: Int,
    val picturename: String
)

fun getAllPicturesClass() : ArrayList<PicturesClass>
{
    return arrayListOf(

    PicturesClass(R.drawable.pic1, picturename = "pic 1"),
    PicturesClass(R.drawable.pic3, picturename = "pic 3"),
    PicturesClass(R.drawable.pic4, picturename = "pic 4"),
    PicturesClass(R.drawable.pic5, picturename = "pic 5"),
    PicturesClass(R.drawable.pic6, picturename = "pic 6"),
    PicturesClass(R.drawable.pic7, picturename = "pic 7"),
    PicturesClass(R.drawable.pic8, picturename = "pic 8"),
    PicturesClass(R.drawable.pic9, picturename = "pic 9"),
    PicturesClass(R.drawable.pic10, picturename = "pic 10"),
    PicturesClass(R.drawable.pic11, picturename = "pic 11"),
    PicturesClass(R.drawable.pic12, picturename = "pic 12"),
    PicturesClass(R.drawable.pic13, picturename = "pic 13"),
    PicturesClass(R.drawable.pic14, picturename = "pic 14")

    )
}
