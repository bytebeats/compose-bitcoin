package me.bytebeats.compose.bitcoin.enums

/**
 * Created by bytebeats on 2021/11/24 : 11:44
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
enum class RollingAverage(val value: String) {
    HOUR("1hour"),
    FOUR_HOUR("4hours"),
    EIGHT_HOURS("8hours"),
    ONE_DAY("24hours"),
    ONE_WEAK("1week"),
    FOUR_WEEKS("4weeks"),
}