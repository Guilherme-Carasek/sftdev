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
}
