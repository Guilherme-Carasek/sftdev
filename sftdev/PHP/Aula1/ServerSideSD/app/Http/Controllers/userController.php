<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class userController extends Controller
{
    public function showAllUsers() {
        $cesaeInfo = $this->getCesaeInfo();
        $allContacts = $this->getAllContacts();
        $allUsers = $this->getAllUsers();

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

    protected function getAllUsers () {
        $allUsers = DB::table('users')->get();
        return $allUsers;
    }

    public function addSara(){
        DB::table('users')->insert([
            'name' => 'Sara',
            'email' => 'sara3@gmail.com',
            'password' => 'Sara1234!'
        ]);
    }

    public function showUser($id){
        $user = DB::table('users')
        ->leftJoin('tasks', 'tasks.user_id', 'users.id')
        ->leftJoin('gifts', 'gifts.user_id', 'users.id')
        ->where ('users.id', $id)
        ->select('users.id', 'users.name', 'users.email', 'users.adress',
        'tasks.id as taskId', 'tasks.name as taskName', 'gifts.id as giftId', 'gifts.name as giftName'/* 'tasks.*', 'gifts.*' */)
        ->get();

        return view('users.user_info', compact('user'));
    }

    public function deleteUser($id){
        DB::table('tasks')
        ->where('user_id', $id)
        ->delete();

        DB::table('gifts')
        ->where('user_id', $id)
        ->delete();

        DB::table('users')
        ->where('id', $id)
        ->delete();

        return redirect()->route('users.show')->with('message', 'Utilizador removido com sucesso');
    }

    public function createUser(Request $request){
        $request->validate([
            'name' => 'required | String | min:3',
            'email' => 'required | email | unique:users',
            'password' => 'required | min:6'
        ]);

        User::insert([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password)
        ]);

        return redirect()->route('users.show')->with('message', 'Utilizador adicionado com sucesso');
    }
}
