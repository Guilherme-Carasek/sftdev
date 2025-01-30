<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class giftController extends Controller
{
    public function showAllGifts(){
        $gifts = $this->getAllGifts();

        return view('gifts.all_gifts', compact('gifts'));
    }

    protected function getAllGifts(){
        $gifts = DB::table('gifts')
        ->join('users', 'users.id', '=', 'gifts.user_id')
        ->select('gifts.*', 'users.name as userName')
        ->get();
        return $gifts;
    }

    public function showGift($id){
        $gift = DB::table('gifts')
        ->join('users', 'users.id', '=', 'gifts.user_id')
        ->where('gifts.id', '=', $id)
        ->select('gifts.*', 'users.name as userName', 'users.email', 'users.adress')
        ->first();


        return view('gifts.gift_info', compact('gift'));
    }

    public function addGifts() {
        $users = DB::table('users')
        ->select('users.name', 'users.id')
        ->get();

        return view('gifts.add_gift', compact('users'));
    }

    public function addGift (Request $request) {
        //
    }
}
