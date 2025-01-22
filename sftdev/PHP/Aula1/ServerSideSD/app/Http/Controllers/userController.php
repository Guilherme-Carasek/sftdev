<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class userController extends Controller
{
    public function showAllUsers() {
        $cesaeInfo = $this->getCesaeInfo();
        $allContacts = $this->getAllContacts();
        $allUsers = $this->getAllusersFromDB();

        return view('users.all_users', compact('cesaeInfo', 'allContacts', 'allUsers'));
    }

    public function addUsers() {
        return view('users.add_users');
    }

    private function getCesaeInfo (){
        $cesaeInfo = [
            'name' => 'CESAE Digital',
            'adress' => 'R. Ciríaco Cardoso 186, BoaVista, Porto',
            'email' => 'cesaedigital@cesaedigital.pt'
        ];
        return $cesaeInfo;
    }

    protected function getAllContacts () {
        $contacts = [
            ['id' => '1', 'name' => 'Sara', 'number' => '911344588'],
            ['id' => '2', 'name' => 'Bruno', 'number' => '911344588'],
            ['id' => '3', 'name' => 'Márcia', 'number' => '911344588']
        ];
        return $contacts;
    }

    protected function getAllusersFromDB(){
        $users = DB::table('users')->get();
        return $users;
    }

    public function addSara(){
        /* DB::table('users')->insert([
            'name' => 'Sara',
            'email' => 'sara3@mail.com',
            'password' => 'Sara1234!'
        ]);
        return response()->json('utilizador inserido'); */

        /* DB::table('users')->where('id', 3)->update([
            'adress' => 'Rua Sara'
        ]); */

    }
}
