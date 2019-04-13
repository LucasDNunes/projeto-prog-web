import {
  Component
} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  categorias = [{
      'id': 1,
      'nome': 'Categoria1'
    },
    {
      'id': 2,
      'nome': 'Categoria2'
    }
  ];
}
