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

    public function addGifts($giftId) {
        $users = DB::table('users')
        ->select('users.name', 'users.id')
        ->get();


        if( $giftId != 0 ){
            $gift = DB::table('gifts')
            ->join('users', 'users.id', 'gifts.user_id')
            ->where('gifts.id', $giftId)
            ->select('gifts.*', 'users.name as userName')
            ->first();
        }
        else $gift = (object) array('id' => 0);

        return view('gifts.add_gift', compact('users', 'gift'));
    }

    public function addGift (Request $request) {
        $request->validate([
            'name' => 'required | String',
            'userId' => 'required | exists:users,id',
            'expectedValue' => 'required | decimal:0,2',
            'spentValue' => 'nullable | decimal:0,2'
        ]);
        if (!isset($request->giftId)){

            DB::table('gifts')->insert([
                'name' => $request->name,
                'expectedValue' => $request->expectedValue,
                'user_id' => $request->userId,
                'spentValue' => $request->spentValue
            ]);

            return redirect()->route('gifts.show')->with('message', 'Prenda adicionada com sucesso');
        }
        else{
            $request->validate(['giftId'=>'exists:gifts,id']);

            DB::table('gifts')
            ->where('id', $request->giftId)
            ->update([
                'name' => $request->name,
                'expectedValue' => $request->expectedValue,
                'user_id' => $request->userId,
                'spentValue' => $request->spentValue
            ]);

            return redirect()->route('gifts.show')->with('message', 'Prenda editada com sucesso');
        }
    }

    public function deleteGift ($id) {
        DB::table('gifts')
        ->where('id', $id)
        ->delete();

        return redirect()->route('gifts.show')->with('message', 'Prenda removida com sucesso');
    }
}
