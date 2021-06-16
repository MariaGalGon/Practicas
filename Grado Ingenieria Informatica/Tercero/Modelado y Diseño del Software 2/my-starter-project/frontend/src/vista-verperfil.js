import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-verdatoscibernauta.js';
import './vista-verdatos.js';
import './vista-listamensajes.js';
import './vista-vermensajes.js';
import './vista-verpedidos.js';

class VistaVerperfil extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
        			margin: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: stretch; padding: 0px; margin: 0px;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout style="align-self: stretch; flex-grow: 0; align-items: center; margin: var(--lumo-space-s);" id="cabeceras">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="ironIcon"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="titulo_admin" style="flex-grow: 1;">Vista Administrador</h2>
  <h2 id="titulo_perfil">Perfil</h2>
  <vaadin-text-field label="" placeholder="search..." style="flex-grow: 1;" id="barra_busqueda"></vaadin-text-field>
  <vaadin-button id="boton_buscar">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_carrito">
   <iron-icon icon="vaadin:cart" id="icono_carrito"></iron-icon>
  </vaadin-button>
  <label id="contador"></label>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
   <iron-icon icon="lumo:user" id="ironIcon1"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="layout_tabs"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="contenido_tabs" style="align-self: stretch;"></vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing-xs" style="align-self: stretch;" id="botones_repartidor">
  <vaadin-button id="tab_envios" style="flex-grow: 1;">
    Envios 
  </vaadin-button>
  <vaadin-button id="tab_perfil" style="flex-grow: 1;">
    Perfil 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verperfil';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerperfil.is, VistaVerperfil);
