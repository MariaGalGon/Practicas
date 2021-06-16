import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-menu-bar/src/vaadin-menu-bar-button.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';

class VistaVermasenvio extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="cabecera" style="margin: var(--lumo-space-s); align-items: center;">
  <img id="logo">
  <h2 style="align-self: center;" id="titulo">Envíos</h2>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%; flex-grow: 1; align-self: center; justify-content: center; padding: var(--lumo-space-l); align-items: center;" id="datos">
  <p id="id_nombre" style="align-self: center; font-weight: bold;"></p>
  <p id="cliente" style="align-self: center;"></p>
  <p id="direccion" style="align-self: center;"></p>
  <vaadin-button id="boton_entregado" style="align-self: center;"></vaadin-button>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing-xs" style="align-self: stretch;">
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
        return 'vista-vermasenvio';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVermasenvio.is, VistaVermasenvio);
