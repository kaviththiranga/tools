/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.wso2.developerstudio.eclipse.ds.util.DsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support
 * Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into
 * calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DsItemProviderAdapterFactory extends DsAdapterFactory implements
                                                                  ComposeableAdapterFactory,
                                                                  IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this
	 * adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement
	 * {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by
	 * {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.AttributeMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttributeMappingItemProvider attributeMappingItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createAttributeMappingAdapter() {
		if (attributeMappingItemProvider == null) {
			attributeMappingItemProvider = new AttributeMappingItemProvider(this);
		}

		return attributeMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.CallQuery} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CallQueryItemProvider callQueryItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.CallQuery}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createCallQueryAdapter() {
		if (callQueryItemProvider == null) {
			callQueryItemProvider = new CallQueryItemProvider(this);
		}

		return callQueryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.CallQueryList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CallQueryListItemProvider callQueryListItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.CallQueryList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createCallQueryListAdapter() {
		if (callQueryListItemProvider == null) {
			callQueryListItemProvider = new CallQueryListItemProvider(this);
		}

		return callQueryListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.ConfigurationProperty}
	 * instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConfigurationPropertyItemProvider configurationPropertyItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.ConfigurationProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createConfigurationPropertyAdapter() {
		if (configurationPropertyItemProvider == null) {
			configurationPropertyItemProvider = new ConfigurationPropertyItemProvider(this);
		}

		return configurationPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.CustomValidator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CustomValidatorItemProvider customValidatorItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.CustomValidator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createCustomValidatorAdapter() {
		if (customValidatorItemProvider == null) {
			customValidatorItemProvider = new CustomValidatorItemProvider(this);
		}

		return customValidatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.DataService} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DataServiceItemProvider dataServiceItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.DataService}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createDataServiceAdapter() {
		if (dataServiceItemProvider == null) {
			dataServiceItemProvider = new DataServiceItemProvider(this);
		}

		return dataServiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration}
	 * instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DataSourceConfigurationItemProvider dataSourceConfigurationItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createDataSourceConfigurationAdapter() {
		if (dataSourceConfigurationItemProvider == null) {
			dataSourceConfigurationItemProvider = new DataSourceConfigurationItemProvider(this);
		}

		return dataSourceConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Description} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DescriptionItemProvider descriptionItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Description}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createDescriptionAdapter() {
		if (descriptionItemProvider == null) {
			descriptionItemProvider = new DescriptionItemProvider(this);
		}

		return descriptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.DocumentRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DocumentRootItemProvider documentRootItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.DocumentRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createDocumentRootAdapter() {
		if (documentRootItemProvider == null) {
			documentRootItemProvider = new DocumentRootItemProvider(this);
		}

		return documentRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator}
	 * instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DoubleRangeValidatorItemProvider doubleRangeValidatorItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createDoubleRangeValidatorAdapter() {
		if (doubleRangeValidatorItemProvider == null) {
			doubleRangeValidatorItemProvider = new DoubleRangeValidatorItemProvider(this);
		}

		return doubleRangeValidatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.ElementMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ElementMappingItemProvider elementMappingItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.ElementMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createElementMappingAdapter() {
		if (elementMappingItemProvider == null) {
			elementMappingItemProvider = new ElementMappingItemProvider(this);
		}

		return elementMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.EventSubscriptionList}
	 * instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EventSubscriptionListItemProvider eventSubscriptionListItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.EventSubscriptionList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createEventSubscriptionListAdapter() {
		if (eventSubscriptionListItemProvider == null) {
			eventSubscriptionListItemProvider = new EventSubscriptionListItemProvider(this);
		}

		return eventSubscriptionListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.EventTrigger} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EventTriggerItemProvider eventTriggerItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.EventTrigger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createEventTriggerAdapter() {
		if (eventTriggerItemProvider == null) {
			eventTriggerItemProvider = new EventTriggerItemProvider(this);
		}

		return eventTriggerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.ExcelQuery} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExcelQueryItemProvider excelQueryItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.ExcelQuery}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createExcelQueryAdapter() {
		if (excelQueryItemProvider == null) {
			excelQueryItemProvider = new ExcelQueryItemProvider(this);
		}

		return excelQueryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Expression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExpressionItemProvider expressionItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createExpressionAdapter() {
		if (expressionItemProvider == null) {
			expressionItemProvider = new ExpressionItemProvider(this);
		}

		return expressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GSpreadQueryItemProvider gSpreadQueryItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createGSpreadQueryAdapter() {
		if (gSpreadQueryItemProvider == null) {
			gSpreadQueryItemProvider = new GSpreadQueryItemProvider(this);
		}

		return gSpreadQueryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.HasHeader} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected HasHeaderItemProvider hasHeaderItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.HasHeader}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createHasHeaderAdapter() {
		if (hasHeaderItemProvider == null) {
			hasHeaderItemProvider = new HasHeaderItemProvider(this);
		}

		return hasHeaderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.LengthValidator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LengthValidatorItemProvider lengthValidatorItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.LengthValidator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createLengthValidatorAdapter() {
		if (lengthValidatorItemProvider == null) {
			lengthValidatorItemProvider = new LengthValidatorItemProvider(this);
		}

		return lengthValidatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.LongRangeValidator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LongRangeValidatorItemProvider longRangeValidatorItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.LongRangeValidator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createLongRangeValidatorAdapter() {
		if (longRangeValidatorItemProvider == null) {
			longRangeValidatorItemProvider = new LongRangeValidatorItemProvider(this);
		}

		return longRangeValidatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.MaxRowCount} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MaxRowCountItemProvider maxRowCountItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.MaxRowCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createMaxRowCountAdapter() {
		if (maxRowCountItemProvider == null) {
			maxRowCountItemProvider = new MaxRowCountItemProvider(this);
		}

		return maxRowCountItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Operation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OperationItemProvider operationItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createOperationAdapter() {
		if (operationItemProvider == null) {
			operationItemProvider = new OperationItemProvider(this);
		}

		return operationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.ParameterMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ParameterMappingItemProvider parameterMappingItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.ParameterMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createParameterMappingAdapter() {
		if (parameterMappingItemProvider == null) {
			parameterMappingItemProvider = new ParameterMappingItemProvider(this);
		}

		return parameterMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.PatternValidator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PatternValidatorItemProvider patternValidatorItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.PatternValidator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createPatternValidatorAdapter() {
		if (patternValidatorItemProvider == null) {
			patternValidatorItemProvider = new PatternValidatorItemProvider(this);
		}

		return patternValidatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Query} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryItemProvider queryItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Query}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createQueryAdapter() {
		if (queryItemProvider == null) {
			queryItemProvider = new QueryItemProvider(this);
		}

		return queryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.QueryParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryParameterItemProvider queryParameterItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.QueryParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createQueryParameterAdapter() {
		if (queryParameterItemProvider == null) {
			queryParameterItemProvider = new QueryParameterItemProvider(this);
		}

		return queryParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.QueryProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryPropertyItemProvider queryPropertyItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.QueryProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createQueryPropertyAdapter() {
		if (queryPropertyItemProvider == null) {
			queryPropertyItemProvider = new QueryPropertyItemProvider(this);
		}

		return queryPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.QueryPropertyList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryPropertyListItemProvider queryPropertyListItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.QueryPropertyList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createQueryPropertyListAdapter() {
		if (queryPropertyListItemProvider == null) {
			queryPropertyListItemProvider = new QueryPropertyListItemProvider(this);
		}

		return queryPropertyListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Resource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ResourceItemProvider resourceItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Resource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createResourceAdapter() {
		if (resourceItemProvider == null) {
			resourceItemProvider = new ResourceItemProvider(this);
		}

		return resourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.ResultMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ResultMappingItemProvider resultMappingItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.ResultMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createResultMappingAdapter() {
		if (resultMappingItemProvider == null) {
			resultMappingItemProvider = new ResultMappingItemProvider(this);
		}

		return resultMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Sparql} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SparqlItemProvider sparqlItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Sparql}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createSparqlAdapter() {
		if (sparqlItemProvider == null) {
			sparqlItemProvider = new SparqlItemProvider(this);
		}

		return sparqlItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Sql} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SqlItemProvider sqlItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Sql}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createSqlAdapter() {
		if (sqlItemProvider == null) {
			sqlItemProvider = new SqlItemProvider(this);
		}

		return sqlItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.StartingRow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StartingRowItemProvider startingRowItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.StartingRow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createStartingRowAdapter() {
		if (startingRowItemProvider == null) {
			startingRowItemProvider = new StartingRowItemProvider(this);
		}

		return startingRowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.Subscription} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SubscriptionItemProvider subscriptionItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.Subscription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createSubscriptionAdapter() {
		if (subscriptionItemProvider == null) {
			subscriptionItemProvider = new SubscriptionItemProvider(this);
		}

		return subscriptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.TargetTopic} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TargetTopicItemProvider targetTopicItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.TargetTopic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createTargetTopicAdapter() {
		if (targetTopicItemProvider == null) {
			targetTopicItemProvider = new TargetTopicItemProvider(this);
		}

		return targetTopicItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.WorkBookName} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkBookNameItemProvider workBookNameItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.WorkBookName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createWorkBookNameAdapter() {
		if (workBookNameItemProvider == null) {
			workBookNameItemProvider = new WorkBookNameItemProvider(this);
		}

		return workBookNameItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.wso2.developerstudio.eclipse.ds.WorkSheetNumber} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkSheetNumberItemProvider workSheetNumberItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.wso2.developerstudio.eclipse.ds.WorkSheetNumber}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter createWorkSheetNumberAdapter() {
		if (workSheetNumberItemProvider == null) {
			workSheetNumberItemProvider = new WorkSheetNumberItemProvider(this);
		}

		return workSheetNumberItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the
	 * adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to
	 * {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if (attributeMappingItemProvider != null)
			attributeMappingItemProvider.dispose();
		if (callQueryItemProvider != null)
			callQueryItemProvider.dispose();
		if (callQueryListItemProvider != null)
			callQueryListItemProvider.dispose();
		if (configurationPropertyItemProvider != null)
			configurationPropertyItemProvider.dispose();
		if (customValidatorItemProvider != null)
			customValidatorItemProvider.dispose();
		if (dataServiceItemProvider != null)
			dataServiceItemProvider.dispose();
		if (dataSourceConfigurationItemProvider != null)
			dataSourceConfigurationItemProvider.dispose();
		if (descriptionItemProvider != null)
			descriptionItemProvider.dispose();
		if (documentRootItemProvider != null)
			documentRootItemProvider.dispose();
		if (doubleRangeValidatorItemProvider != null)
			doubleRangeValidatorItemProvider.dispose();
		if (elementMappingItemProvider != null)
			elementMappingItemProvider.dispose();
		if (eventSubscriptionListItemProvider != null)
			eventSubscriptionListItemProvider.dispose();
		if (eventTriggerItemProvider != null)
			eventTriggerItemProvider.dispose();
		if (excelQueryItemProvider != null)
			excelQueryItemProvider.dispose();
		if (expressionItemProvider != null)
			expressionItemProvider.dispose();
		if (gSpreadQueryItemProvider != null)
			gSpreadQueryItemProvider.dispose();
		if (hasHeaderItemProvider != null)
			hasHeaderItemProvider.dispose();
		if (lengthValidatorItemProvider != null)
			lengthValidatorItemProvider.dispose();
		if (longRangeValidatorItemProvider != null)
			longRangeValidatorItemProvider.dispose();
		if (maxRowCountItemProvider != null)
			maxRowCountItemProvider.dispose();
		if (operationItemProvider != null)
			operationItemProvider.dispose();
		if (parameterMappingItemProvider != null)
			parameterMappingItemProvider.dispose();
		if (patternValidatorItemProvider != null)
			patternValidatorItemProvider.dispose();
		if (queryItemProvider != null)
			queryItemProvider.dispose();
		if (queryParameterItemProvider != null)
			queryParameterItemProvider.dispose();
		if (queryPropertyItemProvider != null)
			queryPropertyItemProvider.dispose();
		if (queryPropertyListItemProvider != null)
			queryPropertyListItemProvider.dispose();
		if (resourceItemProvider != null)
			resourceItemProvider.dispose();
		if (resultMappingItemProvider != null)
			resultMappingItemProvider.dispose();
		if (sparqlItemProvider != null)
			sparqlItemProvider.dispose();
		if (sqlItemProvider != null)
			sqlItemProvider.dispose();
		if (startingRowItemProvider != null)
			startingRowItemProvider.dispose();
		if (subscriptionItemProvider != null)
			subscriptionItemProvider.dispose();
		if (targetTopicItemProvider != null)
			targetTopicItemProvider.dispose();
		if (workBookNameItemProvider != null)
			workBookNameItemProvider.dispose();
		if (workSheetNumberItemProvider != null)
			workSheetNumberItemProvider.dispose();
	}

}
