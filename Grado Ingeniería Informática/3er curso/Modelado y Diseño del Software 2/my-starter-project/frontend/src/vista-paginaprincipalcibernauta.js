import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import './vista-listaproductosdestacados.js';
import './vista-listaofertascibernauta.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class VistaPaginaprincipalcibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-s); width: 100%;" id="cabecera_pagina_principal">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <vaadin-text-field placeholder="search..." id="barra_busqueda" style="flex-grow: 1;"></vaadin-text-field>
  <vaadin-button id="boton_buscar">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_carrito">
   <iron-icon icon="vaadin:cart" id="icono_carrito"></iron-icon>
  </vaadin-button>
  <label id="contador" style="align-self: center; flex-grow: 0;"></label>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
   <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="contenido_pagina_principal" style="align-self: stretch; justify-content: space-between;">
  <img id="anuncio_pagina_principal">
  <vaadin-vertical-layout theme="spacing" id="listas_pagina_principal" style="align-items: stretch; flex-grow: 0; width: 100%;"></vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-paginaprincipalcibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPaginaprincipalcibernauta.is, VistaPaginaprincipalcibernauta);
