import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-producto.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-menu-bar/src/vaadin-menu-bar-button.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-group.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-menu-bar/src/vaadin-menu-bar-submenu.js';

class VistaListaresultadosbusqueda extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="flex-wrap: wrap; width: 100%; justify-content: center;" id="lista_buscar_productos" theme="spacing-l">
 
 
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listaresultadosbusqueda';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaresultadosbusqueda.is, VistaListaresultadosbusqueda);
