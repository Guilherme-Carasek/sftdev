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

    public function taskInfo ($id) {
        $task = DB::table('tasks')
        ->join('users', 'users.id', 'tasks.user_id')
        ->where('tasks.id', $id)
        ->select('tasks.*', 'users.name as userName')
        ->first();

        return view('tasks.task_info', compact('task'));
    }

    public function deleteTask ($id) {
        DB::table('tasks')
        ->where('id', $id)
        ->delete();

        return redirect()->route('tasks.show')->with('message', 'Tarefa eliminada com sucesso');
    }

    public function completeTask ($id) {
        DB::table('tasks')
        ->where('id', $id)
        ->update(['status' => 1]);

        return back();
    }

    public function addTasks(){
        $users = DB::table('users')
        ->select('name', 'id')
        ->get();

        return view('tasks.add_tasks', compact('users'));
    }

    public function addTask(Request $request){
        $request->validate([
            'name'=> 'required | String',
            'description'=> 'nullable | String',
            'dueDate'=> 'nullable | after:today',
            'userId'=> 'required | exists:users,id'
        ]);

        DB::table('tasks')->insert([
            'name' => $request->name,
            'description' => $request->description,
            'due_at' => $request->dueDate,
            'user_id' => $request->userId
        ]);

        return redirect()->route('tasks.show')->with('message', 'Tarefa inserida com sucesso');
    }
}
