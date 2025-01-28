@extends('layouts.main_layout')
@section('content')

    <h1>Adicionar tarefa</h1>
    <div class="row justify-contents-center">
        <div class="col-12 col-lg-6">
            <form method="POST" action=" {{route('task.add')}} ">
                @csrf
                <div class="mb-3">
                    <label for="nameInput" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nameInput" name="name">
                    @error('name')
                        Nome inválido
                    @enderror
                </div>
                <div class="mb-3">
                <label for="descriptionInput" class="form-label">Descrição</label>
                <input type="text" rows="3" class="form-control" id="descriptionInput" name="description">
                @error('description')
                        Descrição inválida
                @enderror
                </div>
                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="dateInput" class="form-label">Prazo</label>
                        <input type="date" class="form-control" id="dateInput" name="dueDate">
                        @error('dueDate')
                            Data inválida
                        @enderror
                    </div>

                    <div class="mb-3 col-6">
                        <label for="userInput" class="form-label">Responsável</label>
                        <select class="form-select" name="userId" id="userInput">
                            <option selected>Utilizador</option>
                            @foreach ($users as $user)
                                <option value=" {{$user->id}} "> {{$user->name}} </option>
                            @endforeach
                        </select>
                        @error('name')
                            Utilizador inválido
                        @enderror
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>
@endsection
