@extends ('layouts.main_layout')
@section ('content')
{{-- {{dd($users)}} --}}
<h1>Adicionar prenda</h1>
    <div class="row justify-contents-center">
        <div class="col-12 col-lg-6">
            <form method="POST" action=" {{route('gift.add')}} ">
                @csrf
                <div class="mb-3">
                    <label for="nameInput" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nameInput" name="name"
                    @if( isset($gift->name) ) value=" {{$gift->name}} " @endif >
                    @error('name')
                        Nome inválido
                    @enderror
                </div>
                <div class="mb-3">
                    <label for="userInput" class="form-label">Presenteado</label>
                    <select class="form-select" name="userId" id="userInput">
                        @if( $gift->id == 0 )
                            <option selected>Utilizador</option>
                        @else
                            <option selected value=" {{$gift->user_id}} "> {{$gift->userName}} </option>
                        @endif

                        @foreach ($users as $user)
                            <option value=" {{$user->id}} "> {{$user->name}} </option>
                        @endforeach
                    </select>
                    @error('name')
                        Utilizador inválido
                    @enderror
                </div>
                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="expectedValueInput" class="form-label">Valor esperado</label>
                        <input type="text" class="form-control" id="expectedValueInput" name="expectedValue"
                        @if(isset($gift->expectedValue)) value=" {{$gift->expectedValue}} " @endif >
                        @error('expectedValue')
                            Valor inválido
                        @enderror
                    </div>
                    <div class="mb-3 col-6">
                        <label for="spentValueInput" class="form-label">Valor gasto</label>
                        <input type="text" class="form-control" id="spentValueInput" name="spentValue"
                        @if( isset($gift->spentValue) ) value=" {{ $gift->spentValue }} " @endif >
                        @error('spentValue')
                            Valor inválido
                        @enderror
                    </div>
                </div>
                @if ($gift->id != 0)
                    <input hidden type="text" name="giftId" value=" {{$gift->id}} ">
                @endif
                <button type="submit" class="btn btn-danger">Registar</button>
            </form>
        </div>
    </div>

@endsection
