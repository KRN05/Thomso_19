package com.example.laxiweldemo.eventsDays

interface OnItemClickListener <T> {

    /**
     * Invokes once the item is clicked
     */
    fun onItemClick(item: T)
}