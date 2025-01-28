<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class taskController extends Controller
{
    public function showAllTasks(){
        $tasks = $this->getTasks();
        return view('tasks.all_tasks', compact('tasks'));
    }

    protected function getTasks(){
        $tasks = DB::table('tasks')
        ->join('users', 'tasks.user_id', '=', 'users.id')
        ->select('tasks.*', 'users.name as userName')
        ->get();
        /* dd($tasks); */
        return $tasks;
    }

    public function addTasks(){
        return view('tasks.add_tasks');
    }

    public function addTask(Request $request){
        $request->validate([
            'name'=> 'required | String',
            'description'=> 'nullable | text',
            'dueDate'=> 'nullable | before_or_equal:now()',
            'userId'=> 'required'
        ]);

    }
}
