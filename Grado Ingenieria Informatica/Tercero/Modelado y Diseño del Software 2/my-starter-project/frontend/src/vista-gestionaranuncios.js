import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';
import './vista-editaranuncio.js';
import './vista-listaanuncios.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaGestionaranuncios extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-items: center; margin: var(--lumo-space-s); align-self: stretch;">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu" style="align-self: center;">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="titulo_gestionar_anuncios">Gestionar Anuncios</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="flex-grow: 1; align-self: center; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing-xl" id="cuerpo_gestionar_anuncios" style="align-self: stretch; margin: var(--lumo-space-m);">
  <vaadin-vertical-layout theme="spacing" id="cuadro_vista">
   <h4 id="titulo_vista" style="align-self: center;">Vista</h4>
   <img id="imagen_vista">
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="spacing-xl" id="vaadinHorizontalLayout2" style="flex-grow: 1; justify-content: flex-end; margin-right: var(--lumo-space-xl);">
   <vaadin-vertical-layout theme="spacing" id="layout_editar" style="flex-grow: 1;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="cuadro_lista_anuncios" style="flex-grow: 1;">
    <h4 id="titulo_lista_anuncios">Lista Anuncios</h4>
    <vaadin-vertical-layout theme="spacing" id="layout_lista" style="align-self: stretch;"></vaadin-vertical-layout>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-gestionaranuncios';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaGestionaranuncios.is, VistaGestionaranuncios);
