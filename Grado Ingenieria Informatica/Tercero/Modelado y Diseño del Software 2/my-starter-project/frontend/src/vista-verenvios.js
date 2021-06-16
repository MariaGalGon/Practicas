import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import './vista-listaenvios.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaVerenvios extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="cabecera" style="margin: var(--lumo-space-s); align-items: center;">
  <img id="logo">
  <h2 style="align-self: center;" id="h2">Envíos</h2>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="layout_envios" style="align-items: center; justify-content: flex-end; flex-grow: 1; width: 100%; align-self: stretch;"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="align-self: stretch; flex-grow: 1; justify-content: space-between; height: 100%; width: 100%;">
  <vaadin-vertical-layout theme="spacing-xl" style="flex-grow: 1; width: 100%; height: 100%; margin: var(--lumo-space-xl);"></vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="spacing-xs" style="align-self: stretch; flex-grow: 0; align-items: flex-end; width: 100%;">
   <vaadin-button id="tab_envios" style="flex-grow: 1;">
     Envios 
   </vaadin-button>
   <vaadin-button id="tabs_perfil" style="flex-grow: 1;">
     Perfil 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verenvios';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerenvios.is, VistaVerenvios);
