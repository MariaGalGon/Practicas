import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import './vista-categoria.js';
import './vista-listaelementos.js';

class VistaListacategorias extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="cabecera_categorias" style="align-self: stretch; align-items: center; margin: var(--lumo-space-s);">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="titulo_categorias">Categorías</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="flex-grow: 1; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
    <iron-icon icon="lumo:user" id="icon_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-list-box id="lista_categorias" style="align-self: stretch; width: 100%; flex-grow: 1;"></vaadin-list-box>
 <vaadin-horizontal-layout theme="spacing" id="botones" style="margin: var(--lumo-space-m);">
  <vaadin-button id="boton_aniadir_categoria">
    Añadir 
  </vaadin-button>
  <vaadin-button id="boton_seleccionar_categoria">
    Seleccionar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listacategorias';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListacategorias.is, VistaListacategorias);
